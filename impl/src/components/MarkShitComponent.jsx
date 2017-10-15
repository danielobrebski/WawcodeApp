import React from 'react';

class MarkShitComponent extends React.Component {

  constructor(props){
    super(props);
  }

  onClick(like) {
    const href = like ? "accept": "reject";

    fetch("http://localhost:58081/shitter/" + href, {
      method: 'POST',
      headers : {
        'Content-Type' : 'application/json'
      },
      body: JSON.stringify({shitterId: this.props.mark.id})
    })
      .then(res => {})
      .then(json => {localStorage.setItem(clicked,)});

    this.props.rankingChanged(this.props.mark.id, like ? 1 : -1)
  }

  render() {
      return (
        <div className="rateButton">
          <a href="#" onClick={() => this.onClick(true)} className="btn btn-lg btn-success"><span className="glyphicon glyphicon-thumbs-up"/> DO DUPY</a>
          <a href="#" onClick={() => this.onClick(false)} className="btn btn-lg btn-danger"><span className="glyphicon glyphicon-thumbs-down"/> PO CHUJU</a>
        </div>
      )
    }
}

export default MarkShitComponent;
