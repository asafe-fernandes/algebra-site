'use client';

import Header from '@mod/layout/Header';
import './globals.css';
import styles from './layout.module.css';
// import store from '@redux/store';
// import { Provider } from 'react-redux';
import Footer from '@mod/layout/Footer';
import ListMensageBox from '@mod/layout/ListMensageBox';
import TypeMensageBox from '@tps/typeMensageBox';
import { getCookie, setCookie } from '@assets/cookies';
import { useEffect, useState } from 'react';

export default function RootLayout({children}: Readonly<{ children: React.ReactNode}>){
  const [isClient, setIsClient] = useState(false);
  const [theme, setTheme] = useState('light');
  const mensage: TypeMensageBox = {
    content: 'Este site utiliza cookies 🍪 \nUsamos cookies para melhorar sua experiência, personalizar conteúdo e analisar nosso tráfego. Ao continuar navegando, você concorda com o uso de cookies. Para mais informações, consulte nossa Política de Cookies.',
    response: () => { setCookie('acceptedCookie', 'confirmed', 30);},
    type: 'confirm'
  };

  useEffect(() => setIsClient(true), []);

  return (
    <html lang="pt-br">
      <title>MatHub</title>
      <body className={styles[theme]} suppressHydrationWarning={true}>
        {isClient && !getCookie('acceptedCookie', document) && <ListMensageBox {...mensage}/>}
        {isClient && <Header onChangeTheme={setTheme}/>}
        {children}
        <Footer />
        {/* <Provider store={store}>
          <ListMensageBox content={mensage.content} />
          <Header />
          {children}
          <Footer />
        </Provider> */}
      </body>
    </html>
  );
}
