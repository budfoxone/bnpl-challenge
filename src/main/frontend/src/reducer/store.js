import {applyMiddleware, createStore, compose} from 'redux';
import  createSagaMiddleware from 'redux-saga';
import reducers from "./stockPriceReducer";
import sagas from '../sagas';

const composeEnhancer = middleware => {
  return (window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose)(middleware);
}

export default function configureStore(initialState) {
  const sageMiddleware = createSagaMiddleware();
  const middleware = applyMiddleware(sageMiddleware);

  const store = createStore(reducers, initialState, composeEnhancer(middleware));

  sageMiddleware.run(sagas);

  return store;

}

