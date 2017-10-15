import React from 'react';

class Localization extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      lat : 52.244417,
      lng : 21.013611
    };
  }


  componentDidMount(){
    navigator.geolocation.getCurrentPosition( (position) => {
      this.setState({lat : position.coords.latitude, lng : position.coords.longitude});
    });
  }

  render(){
    return(
      this.props.children(this.state)
    )
  }
}

export default Localization;
