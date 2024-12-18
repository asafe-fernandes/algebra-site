import { DetailedHTMLProps, FormHTMLAttributes } from 'react';
import styles from './LoginForm.module.css';
import Section from '@cont/Section';
import BoxCheck from '@comp/form/BoxCheck';
import LinkText from '@comp/actions/LinkText';
import CardButton from '@comp/actions/CardButton';
import { BsGoogle } from 'react-icons/bs';

export default function LoginForm(props: DetailedHTMLProps<FormHTMLAttributes<HTMLFormElement>, HTMLFormElement>){
  return(
    <form className={styles.formContainer} {...props}>
      <h1>Login</h1>

      <Section>
        <CardButton><BsGoogle />Google</CardButton>
      </Section>

      <BoxCheck id='termsandpolicy'>
        Declaro que li e aceito os <LinkText hreflang='pt-br' href='/terms'>Termos</LinkText> e <LinkText hreflang='pt-br' href='/policy'>Políticas</LinkText>.
      </BoxCheck>
    </form>
  );
}