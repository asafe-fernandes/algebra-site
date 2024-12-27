export type TypeMensageBoxTheme = 'alert' | 'error' | 'success' | 'default';

type TypeMensageBox = {
  content?: string
  theme?: TypeMensageBoxTheme
  response?: boolean
};

export default TypeMensageBox;