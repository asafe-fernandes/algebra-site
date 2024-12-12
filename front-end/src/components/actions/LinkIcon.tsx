import Link, { LinkProps } from 'next/link';
import styles from './LinkIcon.module.css';

type TypeLinkIcon = LinkProps & {
  children: React.ReactNode
  target?: string
  hreflang?: string
  rel?: string
}

export default function LinkIcon({children, target, hreflang, rel, ...props}: TypeLinkIcon){
  return(
    <Link target={target} rel={rel} hrefLang={hreflang} className={styles.linkIconContainer} {...props}>{children}</Link>
  );
} 