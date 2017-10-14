const webpack = require('webpack');
const path = require('path');
const fs = require('fs');

const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const nodeEnv = process.env.NODE_ENV || 'development';
const isProduction = nodeEnv === 'production';

const package_json = JSON.parse(fs.readFileSync('./package.json', 'utf8'));
const dependencies = Object.getOwnPropertyNames(package_json.dependencies);

const buildPath = path.join(__dirname, '../../backend/src/main/resources/static');
const imgPath = path.join(__dirname, './src/assets/img');

const extractSass = new ExtractTextPlugin({
  filename: '[name]-[hash].css',
  disable: !isProduction
});

module.exports = {
  devtool: isProduction ? 'source-map' : 'cheap-module-eval-source-map',
  entry: {
    app: './src/index.jsx',
    vendor: dependencies
  },
  output: {
    path: buildPath,
    publicPath: '/',
    filename: '[name]-[hash:8].js',
  },
  module: {
    rules: [{
      test: /\.(js|jsx)$/,
      exclude: /node_modules/,
      use: [{
        loader: 'babel-loader',
        options: {
          presets: ['es2015', 'react']
        }
      }]
    }, {
      test: /\.(png|gif|jpe?g|svg)$/,
      include: imgPath,
      use: 'file-loader?./[name]-[hash:8].[ext]',
    }, {
      test: /\.scss$/,
      use: extractSass.extract({
        use: [{
          loader: 'css-loader'
        }, {
          loader: 'sass-loader'
        }],
        fallback: 'style-loader'
      })
    }]
  },
  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      minChunks: Infinity,
      filename: '[name]-[hash].js',
    }),
    extractSass,
    new HtmlWebpackPlugin({
      filename: './index.html',
      template: './src/index.html',
      favicon: './src/favicon.png'
    })
  ],
  resolve: {
    extensions: ['.js', '.jsx']
  },
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:9000',
        secure: false
      }
    },
    historyApiFallback: true
  }
};
