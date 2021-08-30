import { all } from 'redux-saga/effects';
import { stockPriceSagas } from './stockPriceSaga'

export default function* sagas() {
    yield all([
        ...stockPriceSagas
    ]);
}