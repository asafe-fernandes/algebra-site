import styles from './page.module.css';
import Image from 'next/image';
import { BsPlay } from 'react-icons/bs';
import illustrationImage from '@public/paralympic_winners_podium_cuate.svg';
import Header from '@mod/layout/Header';
import Section from '@cont/Section';
import SectionPattern from '@cont/SectionPattern';
import LinkButton from '@comp/actions/LinkButton';
import Article from '@cont/Article';
import Footer from '@mod/layout/Footer';

export default function LendingPage(){
  return(
    <>
      <Header theme='dark'/>
      <main>
        <SectionPattern>
          <h1>Aprimore seu<br/><strong>CONHECIMENTO!</strong></h1>
          <LinkButton detach href='/questions'>Praticar<BsPlay/> </LinkButton>
        </SectionPattern>
        <Section className={styles.containerFlexCenter}>
          <Image className={styles.image} alt='' src={illustrationImage}/>
          <Article>
            <h2>Você está pronto para ser o <br/> <strong>MELHOR?</strong></h2>
            <p>Suba de posição enquanto resolve desafios e desbloqueie conquistas. Compita com amigos ou alcance o topo no ranking global!</p>
          </Article>
          <LinkButton detach hreflang='pt-br' href='/questions'>Competir agora!</LinkButton>
        </Section>
      </main>
      <Footer theme='dark'/>
    </>
  );
}