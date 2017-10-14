import React from 'react';

class Shitmap extends React.Component {

  static map;

  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    const script = document.createElement("script");
    script.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDPOpGNTu51Icel0d9Ka_OAj0vC6n1uzLI&callback=initMap";
    this.initMap()
  }

  handleSubmit(e) {
    e.preventDefault();
    console.log("XD");
  }

  initMap() {
    this.map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: -34.397, lng: 150.644},
      zoom: 8
    });

    navigator.geolocation.getCurrentPosition(function (position) {
      initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
      this.map.setCenter(initialLocation);
    });

    this.map.zoom = 15;

    google.maps.event.addListener(map, 'bounds_changed', function() {
      console.log("Getting bounds...");
      const bounds = map.getBounds();
      // api call
      const shitters = [
        {
          lat : 52.259340,
          lng : 21.036292,
        },
        {
          lat : 52.269454,
          lng : 20.967496,
        }
      ];

      shitters.forEach((shitter) =>{
        const marker = new google.maps.Marker({
          position: shitter,
          map:  this.map,
          title: 'Hello World!'
        });
        marker.setMap(map);
      })
    })

  }


  render() {
    return (
      <div id="map">

      </div>
    )
  }
};

export default Shitmap;
