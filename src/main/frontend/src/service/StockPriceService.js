import {get, post, purge} from "./rest";

export default class StockPriceService {

    static postBuySellStock(requestDto) {
        return post(`/stockprice/bestvalue`, requestDto);
    }

}