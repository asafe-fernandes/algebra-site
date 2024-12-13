import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import TypeMensageBox, { TypeMensageBoxTheme } from '@tps/typeMensageBox';

const initialState: TypeMensageBox = {
  content: undefined,
  theme: 'default',
  response: undefined
};

const mensageBox = createSlice({
  name: 'mensageBox',
  initialState,
  reducers: {
    mensage: {
      reducer(state, action: PayloadAction<TypeMensageBox>){
        state.content = action.payload.content;
        state.theme = action.payload.theme;
      },
      prepare(content:string, theme?: TypeMensageBoxTheme){
        return { payload: {content, theme} };
      }
    }
  }
});

export const{
  mensage
} = mensageBox.actions;

export default mensageBox.reducer;