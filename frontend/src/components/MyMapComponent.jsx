import React from 'react';

import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"

const MyMapComponent = withScriptjs(withGoogleMap((props) =>
    <GoogleMap
      defaultZoom={8}
      defaultCenter= {props.userLocation} >
      {props.data && props.data.map(({lat,lng}) => <Marker position={ {lat , lng} } />)}
    </GoogleMap>
  ));

export default MyMapComponent;
