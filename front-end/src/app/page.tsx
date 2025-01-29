import styles from './page.module.css';
import Image from 'next/image';
import { BsPlay } from 'react-icons/bs';
import illustrationImage from '@public/paralympic_winners_podium_cuate.svg';
import Section from '@cont/Section';
import SectionPattern from '@cont/SectionPattern';
import LinkButton from '@comp/actions/LinkButton';
import Article from '@cont/Article';

export default function LendingPage(){
  return(
    <main>
      <SectionPattern>
        <h1 className={styles.title}>Aprimore seu<br/><strong>CONHECIMENTO!</strong></h1>
        <LinkButton detach href='/Coliseu'>Praticar<BsPlay/> </LinkButton>
      </SectionPattern>
      <Section className={styles.containerFlexCenter}>
        <Image className={styles.image} alt='' src={illustrationImage}/>
        <Article>
          <h2>Você está pronto para ser o <br/> <strong>MELHOR?</strong></h2>
          <p>Suba de posição enquanto resolve desafios e desbloqueie conquistas. Compita com amigos ou alcance o topo no ranking global!</p>
        </Article>
        <LinkButton detach hreflang='pt-br' href='/Coliseu'>Competir agora!</LinkButton>
      </Section>
    </main>
  );
}