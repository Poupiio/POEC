import {Injectable} from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import { AuthService } from 'src/app/auth.service';

@Injectable({
  providedIn: 'root'
})
export class MyhttpService implements HttpInterceptor {

  constructor(private auth: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("intercepted request to: ", req.url);
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${this.auth.accessToken}` || ""
      }
    });
    const apiReq = authReq.clone({ url: `http://localhost:3001${req.url}` });
    return next.handle(apiReq);
  }
}
