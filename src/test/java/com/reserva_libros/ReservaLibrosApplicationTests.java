package com.reserva_libros;

import com.reserva_libros.domain.dto.BookReservesRequestDto;
import com.reserva_libros.domain.dto.BookReservesResponseDto;
import com.reserva_libros.domain.dto.ReservesRequestDto;
import com.reserva_libros.domain.repository.ReservesRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.mapping.Array;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@SpringBootTest
class ReservaLibrosApplicationTests {

	@Autowired
	private ReservesRepository reservesRepository;

	private ReservesRequestDto reservesRequestDto;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);

		BookReservesRequestDto bookReservesReques1 = new BookReservesRequestDto(1,0221,1, "titulo", "das", "autor");
		BookReservesRequestDto bookReservesReques2 = new BookReservesRequestDto(1,335,1, "titulo", "zdxfa", "autor");

		List<BookReservesRequestDto> bookReservesEntities = new ArrayList<>();

		bookReservesEntities.add(bookReservesReques1);
		bookReservesEntities.add(bookReservesReques2);


		reservesRequestDto = ReservesRequestDto.builder()
				.id(1)
				.customerCardId(123)
				.totalReserves(2)
				.bookReservesEntities(bookReservesEntities)
				.build();

		reservesRepository.save(reservesRequestDto);
	}


	@Test
	void saveReserves() {
		System.out.println(reservesRequestDto.getId()
				+ reservesRequestDto.getCustomerCardId()
				+ reservesRequestDto.getTotalReserves()
		+"\n");

		//reservesRequestDto.getBookReservesEntities().forEach(x -> System.out.println(x));

		//Assertions.assertThat(reservesRequestDto.getBookReservesEntities().size()).isEqualTo(2);
	}

}
