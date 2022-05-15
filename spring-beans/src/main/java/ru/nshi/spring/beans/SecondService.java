package ru.nshi.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author rassafel
 */
@Service
@Scope("prototype")
public class SecondService {
}
