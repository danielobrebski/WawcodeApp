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

  onSubmit(description, openingHour, closingHour) {
    fetch("http://localhost:58081/shitter/add", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({latitude: this.state.data.latitude,
        longitude: this.state.data.longitude,
        description : description,
        openingHour : openingHour,
        closingHour : closingHour,
        })
    });
    console.log(description);
    this.props.onClickPage("MAP");
  }

  render() {
    return (
      <div className="content">
        <div className="header">
          <span className="headerInput">KuperApp</span>
        </div>
        <Localization>
          {(localization) => <AddShitterMap
            onShitterClicked={this.onShitterClicked}
            data={this.state.data}
            userLocation={localization}
            googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places"
            loadingElement={<div style={{height: `100%`}}/>}
            containerElement={<div style={{height: `calc(100% - 2rem`}}/>}
            mapElement={<div style={{height: `100%`}}/>}
          />}
        </Localization>
        <div className="footer">
        <a onClick={() => this.props.onClickPage("MAP")} className="btn btn-lg btn-success buttonBack addElem"><span
          className="glyphicon glyphicon-chevron-left"/></a>
        {this.state.data ? <AddShitterForm onSubmit={this.onSubmit}/> : null}
        </div>
      </div>
    )
  }
  ;
}

export default AddShitter;

