import React, {useState} from "react";
import axios from 'axios';
import './App.css';
import chip from './chip.png';
import visa from './visa.png';
import('./script')

function App() {

  const [cardNumber, setCardNumber] = useState('')
  const [fullName, setFullName] = useState('')
  const [expireDateMonth, setExpireDateMonth] = useState('')
  const [expireDateYear, setExpireDateYear] = useState('')
  const [cvc, setCvc] = useState('')

  const CREDIT_CARD_VALIDATION_URL = 'http://localhost:8080/credit-card/validate';

  const request = () => {
   axios.get(CREDIT_CARD_VALIDATION_URL, {
      params: {
        cardNumber: cardNumber.valueOf(),
        fullName: fullName.valueOf(),
        expireDateMonth: expireDateMonth.valueOf(),
        expireDateYear: expireDateYear.valueOf(),
        cvc: cvc.valueOf()
      }
   }).then((response) => {
        alert(response.data.message)
   }).catch((error) => {
     alert(error.response.data.message)
   })
  }

  return (
    <div className="App" id="app">
      <div className="container">
        <div className="card-container">
          <div className="front">
            <div className="image">
              <img src={chip} alt=""/>
              <img src={visa} alt=""/>
            </div>
            <div className="card-number-box">#### #### #### ####</div>
            <div className="flexbox">
              <div className="box">
                <span>card holder</span>
                <div className="card-holder-name">full name</div>
              </div>
              <div className="box">
                <span>expires</span>
                <div className="expiration">
                  <span className="exp-month">mm</span>
                  <span className="exp-year">yy</span>
                </div>
              </div>
            </div>
          </div>

          <div className="back">
            <div className="stripe"></div>
            <div className="box">
              <span>cvc</span>
              <div className="cvc-box"></div>
              <img src={visa} alt=""/>
            </div>
          </div>

        </div>

        <form>
          <div className="inputBox">
            <input
                type='tel'
                minLength="16"
                maxLength="19"
                placeholder="Card Number"
                className="card-number-input"
                value={cardNumber}
                onChange={e => setCardNumber(e.target.value)}
            />
          </div>
          <div className="inputBox">
            <input
                type="text"
                className="card-holder-input"
                placeholder="Full Name"
                value={fullName}
                onChange={e => setFullName(e.target.value)}
            />
          </div>
          <div className="flexbox">
            <div className="inputBox">
              <span>expiration mm</span>
              <select
                  name="expireDateMonth"
                  className="month-input"
                  value={expireDateMonth}
                  onChange={e => setExpireDateMonth(e.target.value)}
              >
                <option defaultValue="month">month</option>
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
            </div>
            <div className="inputBox">
              <span>expiration yy</span>
              <select
                  name="expireDateYear"
                  className="year-input"
                  value={expireDateYear}
                  onChange={e => setExpireDateYear(e.target.value)}
              >
                <option defaultValue="year">year</option>
                <option value="15">15</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">32</option>
              </select>
            </div>
            <div className="inputBox">
              <span>cvc</span>
              <input
                  type='password'
                  name="CVC"
                  minLength="3"
                  maxLength="4"
                  className="cvc-input"
                  value={cvc}
                  onChange={e => setCvc(e.target.value)}
              />
            </div>
          </div>
          <input type="button" value="button" className="submit-btn" onClick={request}/>
        </form>
      </div>
    </div>
  );
}

export default App;
