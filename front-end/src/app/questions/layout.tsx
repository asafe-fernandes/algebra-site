'use client';

import Footer from '@mod/layout/Footer';
import Header from '@mod/layout/Header';
import ListMensageBox from '@mod/layout/ListMensageBox';

export default function QuestionsLayout({children}: {children: React.ReactNode}){

  return(
    <>
      <ListMensageBox />
      <Header />
      {children}
      <Footer />
    </>
  );
}