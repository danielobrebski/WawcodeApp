import React from 'react';
import MyMapComponent from './MyMapComponent';
import Localization from './Localization';
import MarkShitComponent from './MarkShitComponent';
import AddShitter from './AddShitter';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.onChangedBounds = this.onChangedBounds.bind(this);
    this.onClickedMark = this.onClickedMark.bind(this);
    this.onClickPage = this.onClickPage.bind(this);
    this.state = {
      data: [],
      selectedMark: {isSelected: false, id: null},
      page: "MAP"
    };
  }

  onChangedBounds(bounds) {
    let loc = {
      "downLeftLatitudeLongitude": {
        "latitude": bounds['f']['b'],
        "longitude": bounds['b']['b']
      },
      "upRightLatitudeLongitude": {
        "latitude": bounds['f']['f'],
        "longitude": bounds['b']['f']
      }
    };

    fetch("http://0.0.0.0:8080/shitter/getShittersFromLocation", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(loc)
    })
      .then(res => res.json())
      .then(json => this.setState({data: json}))
  }

  onClickedMark(id) {
    this.setState({
      selectedMark: {isSelected: true, id: id}
    });
  }

  onClickPage(page) {
    this.setState({
      page: page
    });
  }

  showButton() {
    if (!this.state.selectedMark.isSelected)
      return false;

    const clicked = JSON.parse(localStorage.getItem("clicked"));

    if (!clicked)
      return true;

    const clickedMark = clicked[this.state.selectedMark.id];
    return this.state.selectedMark.isSelected && !clickedMark || (clickedMark && (clicked[this.state.selectedMark.id] + 10000 < Date.now()));
  }

  render() {
    console.log(this.state.page);
    if (this.state.page === "MAP") {
      return (
        <div>
          <Localization>
            {(localization) => <MyMapComponent
              onChangedBounds={this.onChangedBounds}
              onClickedMark={this.onClickedMark}
              userLocation={localization}
              data={this.state.data}
              googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places&key=AIzaSyDPOpGNTu51Icel0d9Ka_OAj0vC6n1uzLI"
              loadingElement={<div style={{height: `100%`}}/>}
              containerElement={<div style={{height: `500px`}}/>}
              mapElement={<div style={{height: `100%`}}/>}
            />}
          </Localization>
          {this.showButton() ? <MarkShitComponent
            mark={this.state.selectedMark}
            rankingChanged={(id, rank) => {
              this.setState({
                data: this.state.data.map(d => {
                  return d.id === id ? {
                    latitude: d.latitude,
                    longitude: d.longitude,
                    id: d.id,
                    reputationCounter: d.reputationCounter + rank
                  } : d
                }),
                selectedMark: {isSelected: false, id: null}
              });
            }}/> : null}
          <a onClick={() => this.onClickPage("ADD")} className="btn btn-lg btn-success"><span
            className="glyphicon glyphicon-thumbs-up"/> Dodaj Sracz</a>
        </div>
      )
    } else {
      return (
        <div>
          <AddShitter onClickPage={this.onClickPage}>s
          </AddShitter>
        </div>
      )
    }
  }
};

export default App;
