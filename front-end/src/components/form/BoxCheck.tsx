import { DetailedHTMLProps, InputHTMLAttributes, useState } from 'react';
import styles from './BoxCheck.module.css';
import ButtonIcon from '@comp/actions/ButtonIcon';
import { BsCheckSquareFill, BsSquare } from 'react-icons/bs';

type BoxCheckType = DetailedHTMLProps<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement> & {
  children: React.ReactNode
}

export default function BoxCheck({children, ...props}: BoxCheckType){
  const [value, setValue] = useState(false);
  return(
    <div>
      <input onChange={(e) => setValue(e.target.checked)} className={styles.input} defaultChecked={value} {...props} type='checkbox' />
      <label className={styles.labelContainer} htmlFor={props.id}>
        <ButtonIcon  className={styles.buttonIcon} onClick={() => setValue(!value)} type='button'>
          {!value ? <BsSquare className={styles.icon}/> : <BsCheckSquareFill />}  
        </ButtonIcon>
        {children}
      </label>
    </div>
  );
}