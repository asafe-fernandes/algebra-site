'use client';

import Footer from '@mod/layout/Footer';
import Header from '@mod/layout/Header';

export default function QuestionsLayout({children}: {children: React.ReactNode}){

  return(
    <>
      <Header />
      {children}
      <Footer />
    </>
  );
}