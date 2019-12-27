// package com.tokenjwt.task.security;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Map;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.OncePerRequestFilter;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;

// public class JWTAutorizationFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//                 String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
//                 if(jwt ==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)){
//                     filterChain.doFilter(request, response);
//                     return;
//                 }
//                 System.out.println(" **********jwt=******* "+jwt+" ***************** ");
//                 Claims  claims = Jwts.parser()
//                                 .setSigningKey(SecurityConstants.SECRET)
//                                 .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, "replacement"))
//                                 .getBody();
//                                 System.out.println("************claims=*******"+claims+"****************");
//                         String username = claims.getSubject();

                        
//                         ArrayList<Map<String, String>> roles =(ArrayList<Map<String, String>>) claims.get("roles");


//                         Collection<GrantedAuthority> authorities= new ArrayList<>();
//                         roles.forEach(r-> {
//                             authorities.add(new SimpleGrantedAuthority(r.get("authority")));
//                         });
//                         UsernamePasswordAuthenticationToken authenticationUser = new UsernamePasswordAuthenticationToken(username, null, authorities);
//                         SecurityContextHolder.getContext().setAuthentication(authenticationUser);
//                         filterChain.doFilter(request, response);




                 
//     }

     
// }