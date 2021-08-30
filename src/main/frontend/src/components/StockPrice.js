import React from 'react';
import { connectWithLifecycle } from 'react-lifecycle-component';
import { actions } from '../reducer/stockPriceReducer';

const StockPriceComponent = ({ ...props}) => {
    return (
      <>
        <input type={"button"} onClick={()=> props.postStockPrice()} value={"Get yesterday's MaxProfit"}/>

        <h4>Result</h4>
        <div>
          Buy value: {props.buyValue} <br/>
          Sell value: {props.sellValue} <br/>
          Processed date time: {props.processedDateTime} <br/>
          <strong>Max Profit: {props.maxProfit}</strong> <br/>
        </div>
          {props.stockPrices && <ListStockPrices prices={props.stockPrices} startDate={props.submittedRequest.startDateTime} endDate={props.submittedRequest.endDateTime}/> }

      </>
    );
};

const ListStockPrices = ({prices: stockPrices, startDate: start, endDate: end}) => {

    return (
        <>
            <br/><br/>
            Start Date: {start} <br/>
            End Date: {end} <br/><br/>
            <div>Stock Prices</div>
            <ul>
            {
                Object.entries(stockPrices).map(([key, value]) =>
                    <>
                        <li>{key} : {value}</li>
                    </>
                )
            }
            </ul>
        </>

    );

}

const mapStateToProps = (state) => {
    return { ...state };
}

const mapDispatchToProps = (dispatch) => ({
    postStockPrice: () => {
        dispatch(actions.postStockPrice());
    }
});

export default connectWithLifecycle(mapStateToProps, mapDispatchToProps)(StockPriceComponent);