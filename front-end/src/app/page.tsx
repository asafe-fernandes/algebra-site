import LinkButton from '@comp/actions/LinkButton';
import SectionPattern from '@cont/SectionPattern';
import Header from '@mod/layout/Header';
import { BsPlay } from 'react-icons/bs';

export default function lendingPage(){
  return(
    <>
      <Header theme='dark'/>
      <SectionPattern>
        <h1>Aprimore seu<br/><strong>CONHECIMENTO!</strong></h1>
        <LinkButton detach href='/questions'>Praticar<BsPlay/> </LinkButton>
      </SectionPattern>
      {/* imagem ilustrativa */}
      {/* section 2, cta 2 */}
      {/* Footer dark/black */}
    </>
  );
}