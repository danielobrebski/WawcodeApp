import React from 'react';
import MyMapComponent from './MyMapComponent';
import Localization from './Localization';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    console.log("XD");
  }


  render() {
    return (
      <div>
        <form>
          <button onClick={this.handleSubmit}>Find</button>
        </form>
        <Localization>
          {(localization) => <MyMapComponent
            userLocation = {localization}
            googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places"
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
