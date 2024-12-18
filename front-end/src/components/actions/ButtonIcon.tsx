import { ButtonHTMLAttributes, DetailedHTMLProps } from 'react';
import styles from './ButtonIcon.module.css';

type TypeButton = DetailedHTMLProps<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement> & {
  children: React.ReactNode
  detach?: boolean
  className?: string
}

export default function ButtonIcon({children, detach, className, ...props}: TypeButton){
  return (
    <button className={`${className} ${styles.buttonContainer} ${detach && styles.detach}`} {...props}>{children}</button>
  );
}