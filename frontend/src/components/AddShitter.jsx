import React from 'react';
import Localization from './Localization';
import AddShitterMap from './AddShitterMap';
import AddShitterForm from './AddShitterForm';

class AddShitter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {data: null};
    this.onShitterClicked = this.onShitterClicked.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onShitterClicked(e) {
    this.setState({
      data: {
        latitude: e.latLng.lat(),
        longitude: e.latLng.lng(),
        key: e.fa.x + e.fa.y
      }
    })
  }

  onSubmit() {
    fetch("http://localhost:58081/shitter/add", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({latitude: this.state.data.latitude, longitude: this.state.data.longitude})
    }).then(res => res.json());
    this.props.onClickPage("MAP");
  }

  render() {
    return (
      <div>
        <Localization>
          {(localization) => <AddShitterMap
            onShitterClicked={this.onShitterClicked}
            data={this.state.data}
            userLocation={localization}
            googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places&key=AIzaSyDPOpGNTu51Icel0d9Ka_OAj0vC6n1uzLI"
            loadingElement={<div style={{height: `100%`}}/>}
            containerElement={<div style={{height: `400px`}}/>}
            mapElement={<div style={{height: `100%`}}/>}
          />}
        </Localization>
        <a onClick={() => this.props.onClickPage("MAP")} className="btn btn-lg btn-success"><span
          className="glyphicon glyphicon-thumbs-up"/> Wroc</a>
        {this.state.data ? <AddShitterForm onSubmit={this.onSubmit}/> : null}
      </div>
    )
  }
  ;
}

export default AddShitter;

