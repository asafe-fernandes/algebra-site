'use client';

import Header from '@mod/layout/Header';
import './globals.css';
import store from '@redux/store';
import { Provider } from 'react-redux';
import Footer from '@mod/layout/Footer';

export default function RootLayout({children}: Readonly<{ children: React.ReactNode}>){
  return (
    <html lang="pt-br">
      <title>MatHub</title>
      <body suppressHydrationWarning={true}>
        <Provider store={store}>
          <Header />
          {children}
          <Footer />
        </Provider>
      </body>
    </html>
  );
}
