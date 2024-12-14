import { ButtonHTMLAttributes, DetailedHTMLProps } from 'react';
import styles from './ButtonIcon.module.css';

type TypeButton = DetailedHTMLProps<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement> & {
  children: React.ReactNode
  detach?: boolean
}

export default function ButtonIcon({children, detach, ...props}: TypeButton){
  return (
    <button className={`${styles.buttonContainer} ${detach && styles.detach}`} {...props}>{children}</button>
  );
}