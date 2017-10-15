import React from 'react';

import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"

const MyMapComponent = withScriptjs(withGoogleMap(
  class extends React.Component {



    constructor(props) {
        super(props);
        this.trottledOnChangedBound = this.trottledOnChangedBound.bind(this);
        this.lastApiCall = 0;
        this.timeout = null;
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

    render() {
      return (
        <GoogleMap
          ref={ref => this.ref = ref}
          defaultZoom={8}
          defaultCenter= {this.props.userLocation}
          onBoundsChanged = {this.trottledOnChangedBound}>
          {this.props.data && this.props.data.map(({latitude,longitude}, key) =>
            <Marker position={ {lat : latitude , lng : longitude} }
                    key = {key} />)}
        </GoogleMap>
      )
    }
  }
  ));

export default MyMapComponent;
