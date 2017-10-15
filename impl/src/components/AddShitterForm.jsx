import React from 'react';

class AddShitterForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      description: "",
      openingHour: "",
      closingHour: "",
    };
    this.handleDescription = this.handleDescription.bind(this);
    this.handleOpeningHourn = this.handleOpeningHourn.bind(this);
    this.handleClosingHour = this.handleClosingHour.bind(this);
  }

  handleDescription(e) {
    this.setState({description: e.target.value});
  }

  handleOpeningHourn(e) {
    this.setState({openingHour: e.target.value});
  }

  handleClosingHour(e) {
    this.setState({closingHour: e.target.value});
  }


  render() {
    return (
      <div className="addElem addElemForm"> Nowy punkt
        <div>
          <label>Opis</label>
          <input name="Description" type="text" value={this.state.description} onChange={this.handleDescription}
                 required/>
        </div>
        <div>
          Godziny otwarcia
        </div>
        <div className="from">
          <label>Od :</label>
          <input name="OpeningHour" type="text" value={this.state.openingHour} onChange={this.handleOpeningHourn}
                 required/>
        </div>
        <div className="to">
          <label>Do :</label>
          <input name="ClosingHour" type="text" value={this.state.inputValue} onChange={this.handleClosingHour}
                 required/>
        </div>
        <div className="login-button-wrapper">
          <a className="btn btn-sm btn-default btn-success circle" onClick={this.props.onSubmit} ><span className="glyphicon glyphicon-ok"></span></a>
        </div>
      </div>
    );
  }
}

export default AddShitterForm;
