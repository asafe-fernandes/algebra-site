import Link, { LinkProps } from 'next/link';
import styles from './LinkText.module.css';

type TypeLinkText = LinkProps & {
  children: React.ReactNode
  target?: string
  hreflang?: string
  rel?: string
  style?: 'detach' | 'id'
}

export default function  LinkText({children, target, hreflang, rel, style, ...props}: TypeLinkText){
  return(
    <Link target={target} rel={rel} hrefLang={hreflang} className={`${styles.linkTextContainer} ${style && styles[style]}`} {...props}>{children}</Link>
  );
} 