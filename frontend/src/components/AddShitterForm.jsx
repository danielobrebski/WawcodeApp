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
      <div> Chcesz dodac sracz?
        <div>
          <label>Opis</label>
          <input name="Description" type="text" value={this.state.description} onChange={this.handleDescription}
                 required/>
        </div>
        <div>
          <label>Od</label>
          <input name="OpeningHour" type="text" value={this.state.openingHour} onChange={this.handleOpeningHourn}
                 required/>
        </div>
        <div>
          <label>Do</label>
          <input name="ClosingHour" type="text" value={this.state.inputValue} onChange={this.handleClosingHour}
                 required/>
        </div>
        <div className="login-button-wrapper">
          <button type="submit" className="login-button"
                  onClick={() => this.props.onSubmit(this.state.description, this.state.openingHour)}>&#9658;</button>
        </div>
      </div>
    );
  }
}

export default AddShitterForm;
