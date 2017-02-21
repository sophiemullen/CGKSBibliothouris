package be.cegeka.bibliothouris.domain.user;

import be.cegeka.bibliothouris.domain.user.User;
import be.cegeka.bibliothouris.domain.user.UserRepository;
import be.cegeka.bibliothouris.domain.user.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(userService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("Seppe");

        verify(userRepository).addUser(new User(5l, "Seppe"));
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 = new User(1l, "Seppe");
        User user2 = new User(2l, "Sanne");
        User user3 = new User(3l, "Xan");

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2);
    }
}