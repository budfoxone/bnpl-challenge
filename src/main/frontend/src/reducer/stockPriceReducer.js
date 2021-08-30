import {createAction, handleActions} from 'redux-actions'

const POST_STOCK_PRICE='POST_STOCK_PRICE';
const UPDATE_FIELD='UPDATE_FIELD';
export const constants = {
    POST_STOCK_PRICE,
    UPDATE_FIELD
}
export const postStockPrice = createAction(POST_STOCK_PRICE, ()=>({}));
export const updateField = createAction(UPDATE_FIELD, (name, val)=>({[name] :val}));

export const actions = {
    postStockPrice,
    updateField
}

export const reducers = {
    [UPDATE_FIELD]: (state, {payload}) => ({ ...state, ...payload, }),
}

let today = new Date();
let yesterday = new Date(today);
yesterday.setDate(today.getDate() - 1);
let dd = yesterday.getDate();
let mm = yesterday.getMonth() + 1;
let yyyy = yesterday.getFullYear();
if (dd < 10) {
    dd = '0' + dd;
}
if (mm < 10) {
    mm = '0' + mm;
}
yesterday = `${yyyy}-${mm}-${dd}`;


const randomInt = (min, max) => {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

export const initialState = {
    requestDto: {
        identifier: "test",
        startDateTime: `${yesterday}T10:45:55`,
        endDateTime: `${yesterday}T11:45:55`,
        stockPrices: {
            "60" : `${randomInt(0, 100)}`,
            "61" : `${randomInt(0, 100)}`,
            "1" : `${randomInt(0, 100)}`,
            "9" : `${randomInt(0, 100)}`,
            "30" : `${randomInt(0, 100)}`,
            "70" : `${randomInt(0, 100)}`,
            "71" : `${randomInt(0, 100)}`,
            "72" : `${randomInt(0, 100)}`,
            "100" : `${randomInt(0, 100)}`,
            "7" : `${randomInt(0, 100)}`,
        }
    },
    submittedRequest: {},
    maxProfit: 0,
    buyValue: 0,
    sellValue: 0,
    processedDateTime: ""
}

export default handleActions(reducers, initialState)