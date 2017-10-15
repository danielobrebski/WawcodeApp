import React from 'react';

class AddShitterForm extends React.Component {
  render() {
    return (
      <div className="addElem addElemForm"> Nowy punkt
          <div className="form-field">
            <input name="Opis" type="text"  required/>
          </div>
          <div className="login-button-wrapper">
            <a className="btn btn-sm btn-default btn-success" onClick={this.props.onSubmit} ><span className="glyphicon glyphicon-ok"></span></a>
          </div>
      </div>
    );
  }
}

export default AddShitterForm;
