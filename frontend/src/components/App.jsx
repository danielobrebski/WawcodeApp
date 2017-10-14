import React from 'react';
import MyMapComponent from './MyMapComponent';
import Localization from './Localization';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.onChangedBounds = this.onChangedBounds.bind(this);
    this.state = {data: []};
  }

  onChangedBounds(bounds) {
    let loc = {
      "downLeftLatitudeLongitude": {
        "latitude": bounds['b']['b'],
        "longitude": bounds['f']['b']
      },
      "upRightLatitudeLongitude": {
        "latitude": bounds['b']['f'],
        "longitude": bounds['f']['f']
      }
    };

    fetch("http://localhost:58081/shitter/getShittersFromLocation", {
      method: 'POST',
      headers : {
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify(loc)
    })
      .then(res => res.json())
      .then(json => this.setState({data: json}))
  }

  render() {
    return (
      <div>
        <form>
          <button onClick={this.handleSubmit}>Find</button>
        </form>
        <Localization>
          {(localization) => <MyMapComponent
            onChangedBounds = {this.onChangedBounds}
            userLocation={localization}
            data={this.state.data}
            googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places&key=AIzaSyDPOpGNTu51Icel0d9Ka_OAj0vC6n1uzLI"
            loadingElement={<div style={{height: `100%`}}/>}
            containerElement={<div style={{height: `400px`}}/>}
            mapElement={<div style={{height: `100%`}}/>}
          />}
        </Localization>
      </div>
    )
  }
};

export default App;
