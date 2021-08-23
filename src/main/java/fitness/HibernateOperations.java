package fitness;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateOperations {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		createEntities(session);
		findall(session);
		updateEntities(session);
		findall(session);
		deleteEntities(session);
		findall(session);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	private static void findall(Session session) {
		Query query = session.createQuery("from UserEntity");
		Query query2 = session.createQuery("from AppointmentEntity");
		List<UserEntity> users = query.getResultList();
		List<AppointmentEntity> appointments = query2.getResultList();
		for(UserEntity user : users) {
			System.out.println("ID="+user.getID()+ ", FirstName="+user.getFirstName()+", Age="+user.getAge()+"");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		for(AppointmentEntity app : appointments) {
			System.out.println("ID="+app.getAppID()+ ", Trainer="+app.getTrainerName()+", Package="+app.getPackageName()+", Amount"+app.getAmount());
		}
			
	}

	private static void deleteEntities(Session session) {
		UserEntity user = session.find(UserEntity.class, 2);
		session.delete(user);
		System.out.println("--------------------------------------------------------------------------");

	}

	private static void updateEntities(Session session) {
		UserEntity u = session.find(UserEntity.class, 1);
		u.setFirstName("Legend");
		session.saveOrUpdate(u);
		AppointmentEntity a = session.find(AppointmentEntity.class, 2);
		a.setPackageName("Kryptonian");
		session.saveOrUpdate(a);
		
		System.out.println("------------------------------------");
	}

	private static void createEntities(Session session) {
		//Add Appointment object
		AppointmentEntity appointment = new AppointmentEntity();
		appointment.setTrainerName("Batman");
		appointment.setPhysioRequired(true);
		appointment.setPackageName("Elite");
		appointment.setAmount(800);
		
		AppointmentEntity appointment2 = new AppointmentEntity();
		appointment2.setTrainerName("Superman");
		appointment2.setPhysioRequired(true);
		appointment2.setPackageName("Otherworld");
		appointment2.setAmount(700);
		
		
		//Add User object
		UserEntity user = new UserEntity();
		user.setFirstName("Shahid");
		user.setLastName("Shaikh");
		user.setAge(22);
		user.setAddress("Santacruz");
		
		UserEntity user2 = new UserEntity();
		user2.setFirstName("Vishal");
		user2.setLastName("Singh");
		user2.setAge(21);
		user2.setAddress("Malad");
		//Save Appointment
		session.save(appointment);
		session.save(appointment2);
		//Save User
		user.setAppoinment(appointment);
		user2.setAppoinment(appointment2);
		session.save(user);
		session.save(user2);
	}

}
