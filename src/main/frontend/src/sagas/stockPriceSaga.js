import {call, put, fork, takeLatest, select } from "redux-saga/effects";
import {constants, actions} from "../reducer/stockPriceReducer";
import service from "../service/StockPriceService";

function* stockPrice() {
    let requestDto = yield select(state => state.requestDto);
    let data = yield call(service.postBuySellStock, requestDto);

    if (!data.error) {
        yield put(actions.updateField('submittedRequest', requestDto));
        yield put(actions.updateField('maxProfit', data.maxProfit));
        yield put(actions.updateField('buyValue', data.buyValue));
        yield put(actions.updateField('sellValue', data.sellValue));
        yield put(actions.updateField('processedDateTime', data.processedDateTime));
        yield put(actions.updateField('stockPrices', data.request.stockPrices));
    }
}

function* postStockPrice() {
    yield takeLatest(constants.POST_STOCK_PRICE, stockPrice);
}

export const stockPriceSagas = [
    fork(postStockPrice)
];