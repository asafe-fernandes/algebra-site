export type TypeMensageBoxTheme = 'alert' | 'error' | 'success' | 'default';

type TypeMensageBox = {
  content?: string
  type?: 'default' | 'confirm'
  theme?: TypeMensageBoxTheme
  response?: () => void
};

export default TypeMensageBox;