import React from 'react';

import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"

const MyMapComponent = withScriptjs(withGoogleMap(
  class extends React.Component {

    render() {
      return (
        <GoogleMap
          ref={ref => this.ref = ref}
          defaultZoom={8}
          defaultCenter= {this.props.userLocation}
          onBoundsChanged = {e => this.ref && this.props.onChangedBounds(this.ref.getBounds())}>
          {this.props.data && this.props.data.map(({latitude,longitude,id,reputationCounter}, key) =>
            <Marker position={ {lat : latitude , lng : longitude} }
                    key = {key}
                    onClick= {() => this.props.onClickedMark(id)}
                    label={reputationCounter + ""}/>)}
        </GoogleMap>
      )
    }
  }
  ));

export default MyMapComponent;
