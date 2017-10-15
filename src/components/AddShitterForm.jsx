import React from 'react';

class AddShitterForm extends React.Component {
  render() {
    return (
      <div> Chcesz dodac sracz?
          <div className="form-field">
            <input name="Opis" type="text"  required/>
          </div>
          <div className="login-button-wrapper">
            <button type="submit" className="login-button" onClick={this.props.onSubmit}>&#9658;</button>
          </div>
      </div>
    );
  }
}

export default AddShitterForm;
