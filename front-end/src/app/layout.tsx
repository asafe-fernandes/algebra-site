import './globals.css';

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br">
      <title>Álgebra</title>
      <body suppressHydrationWarning={true}>
        {children}
      </body>
    </html>
  );
}
