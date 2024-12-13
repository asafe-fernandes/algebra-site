'use client';

import './globals.css';
import styles from './layout.module.css';
import store from '@redux/store';
import { Provider } from 'react-redux';

export default function RootLayout({children}: Readonly<{ children: React.ReactNode}>){
  return (
    <html lang="pt-br">
      <title>MatHub</title>
      <body className={styles.layoutContainer} suppressHydrationWarning={true}>
        <Provider store={store}>
          {children}
        </Provider>
      </body>
    </html>
  );
}
