import type { ButtonHTMLAttributes } from "react";

export function Button(props: ButtonHTMLAttributes<HTMLButtonElement>) {
  return <button {...props} style={{ padding: "0.5rem 1rem", borderRadius: 8, ...props.style }} />;
}
