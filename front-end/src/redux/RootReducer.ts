import { combineReducers } from 'redux';
import mensageBox from './reducers/mensageBox/slice';

const RootReducer = combineReducers({mensageBox});

export default RootReducer;