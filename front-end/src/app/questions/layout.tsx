import Footer from '@mod/layout/Footer';
import Header from '@mod/layout/Header';

export default function questionsLayout({children}: {children: React.ReactNode}){
  return(
    <>
      <Header />
      {children}
      <Footer />
    </>
  );
}