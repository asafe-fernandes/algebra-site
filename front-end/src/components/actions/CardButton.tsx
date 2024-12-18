import { ButtonHTMLAttributes, DetailedHTMLProps } from 'react';
import styles from './CardButton.module.css';

type TypeButton = DetailedHTMLProps<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement> & {
  children: React.ReactNode
  detach?: boolean
}

export default function CardButton({children, detach, ...props}: TypeButton){
  return (
    <button className={`${styles.buttonContainer} ${detach && styles.detach}`} {...props}>{children}</button>
  );
}