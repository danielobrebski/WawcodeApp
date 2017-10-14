# PIK-Projekt: Frontend

## Initial setup

To download all the required dependencies run:
```
npm install
```

## Development

During development it is recommended to use the `webpack-dev-server`. To start the server run:
```
npm start
```
This will **not** output any files. Webpack compiles the
code and serves it from memory.

To view the application navigate to [`http://localhost:8080/`](http://localhost:8080/) in the browser.

## Testing

Testing is done using `jest`. To run the tests enter:
```
npm test
```
Jest will automatically find and run all files with the `test.js` or `test.jsx` extension;

## Production

To generate production ready code run:
```
npm run build
```
You can find the code in the `build` folder.

## Coding style

### Javascript

Example:
```javascript
import Something from 'someting/something';
import { Foo, Bar } from './foobar';

class MyClass extends Something.Something {
  constructor(props) {
    super(props);
    this.x = {
      y: []
    };
  }

  foo(bar) {
    return bar;
  }
}
```

**DO**
```javascript
class MyClass {
  foo() {
    bar(x => this.x = x);
  }
}
```

**DON'T**
```javascript
class MyClass {
  foo() {
    var self = this; // BAD!
    bar(function(x) {
      self.x = x;
    });
  }
}
```

### CSS

**DO**
```css
.my-class {
  color: white;
}
```

**DON'T**
```css
.my_class {
  color: white;
}

.myClass {
  color: white;
}

.Myclass {
  color: white;
}
```

### HTML

**DO**
```html

<header>
  <h1 prop="value" prop2={this.prop2}></h1>
</header>
```

**DON'T**
```html
<HEADER>
  <H1 Prop = "value" PROP2 = { this.prop2 } ></H1 >
</HEADER>
```
