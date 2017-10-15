import React from 'react';

import { withScriptjs, withGoogleMap, GoogleMap, Marker, DirectionsRenderer } from "react-google-maps"

const MyMapComponent = withScriptjs(withGoogleMap(
  class extends React.Component {


    constructor(props) {
        super(props);
        this.trottledOnChangedBound = this.trottledOnChangedBound.bind(this);
        this.markerClicked = this.markerClicked.bind(this);
        this.lastApiCall = 0;
        this.timeout = null;
        this.directions = null;
    }

    trottledOnChangedBound() {
        const TIMEOUT = 500;
        let now = Date.now();
        if (now - this.lastApiCall > TIMEOUT) {
            this.lastApiCall = now;
            this.ref && this.props.onChangedBounds(this.ref.getBounds());
        } else {
            clearTimeout(this.timeout);
            this.timeout = setTimeout(() => this.ref && this.props.onChangedBounds(this.ref.getBounds()),
                now - this.lastApiCall)
        }
    }

    markerClicked(id ,lat, lng) {
      const DirectionsService = new google.maps.DirectionsService();

      DirectionsService.route({
        origin: this.props.userLocation,
        destination: {lat : lat, lng : lng},
        travelMode: google.maps.TravelMode.WALKING,
      }, (result, status) => {
        if (status === google.maps.DirectionsStatus.OK) {
          this.setState({
            directions: result,
          });
        } else {
          console.error(`error fetching directions ${result}`);
        }
      });

      this.props.onClickedMark(id)
    }

    render() {
      return (
        <GoogleMap
          ref={ref => this.ref = ref}
          defaultZoom={8}
          defaultCenter= {this.props.userLocation}
          onBoundsChanged = {this.trottledOnChangedBound}>
          {this.props.data && this.props.data.map(({latitude,longitude,id,reputationCounter}, key) =>
            <Marker position={ {lat : latitude , lng : longitude} }
                    key = {key}
                    onClick= {() => this.markerClicked(id,latitude,longitude)}
                    label={reputationCounter + ""}/>)}
          {this.state && this.state.directions && <DirectionsRenderer directions={this.state.directions} />}
        </GoogleMap>
      )
    }
  }
  ));

export default MyMapComponent;
