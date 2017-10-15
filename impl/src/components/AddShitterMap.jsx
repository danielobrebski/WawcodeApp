import React from 'react';

import { withScriptjs, withGoogleMap, GoogleMap, Marker} from "react-google-maps"

const AddShitterMap = withScriptjs(withGoogleMap(
  class extends React.Component {

    constructor(props) {
      super(props);
    }

    render() {
      return (
        <GoogleMap
          ref={ref => this.ref = ref}
          defaultZoom={8}
          defaultCenter= {this.props.userLocation}
          onClick = {this.props.onShitterClicked}>
          {this.props.data &&
            <Marker position={ {lat : this.props.data.latitude , lng : this.props.data.longitude} }
                    key = {this.props.data.key}/>}
        </GoogleMap>
      )
    }
  }
));

export default AddShitterMap;
